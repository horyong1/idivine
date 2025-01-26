package com.lhr.idivine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lhr.idivine.dto.PmidKeywordsDto;
import com.lhr.idivine.dto.RestResponseDto;
import com.lhr.idivine.service.IdivineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/idivine")
public class RestHomeController {

    @Autowired
    private IdivineService idivineService;

    /**
     * 리스트 조회
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<PmidKeywordsDto>> getList(
        @RequestParam( value = "searchType", required = false) String searchType,
        @RequestParam( value = "searchValue", required = false) String searchValue
    ){
        List<PmidKeywordsDto> list = idivineService.findyAll(searchType,searchValue);
        return ResponseEntity.ok(list);
    }
    
    /**
     * keywaord 상세내용
     * @param pmid
     * @return
     */
    @GetMapping("detail/{pmid}")
    public ResponseEntity<PmidKeywordsDto> detail(@PathVariable("pmid")int pmid){
        PmidKeywordsDto dto = idivineService.findByPmid(pmid);
        return ResponseEntity.ok(dto);
    }

    /**
     * 저장
     * @param keywordInfo
     * @return
     */
    @PostMapping("insert")
    public ResponseEntity<RestResponseDto> insert(@RequestBody PmidKeywordsDto params) {
        RestResponseDto responseDto = new RestResponseDto();
        // 받아온 String 값 엔터 공백 값 제거 (그대로 넣으면 가져올때 json 타입 오류)
        String compressedJson = compressedJson(params);
  
        idivineService.create(params.getPmid(),compressedJson);
        responseDto.setResult("Register success");
        return ResponseEntity.ok(responseDto);
    }
    
    @DeleteMapping("delete/{pmid}")
    public ResponseEntity<RestResponseDto> delete(@PathVariable("pmid") int pmid){
        RestResponseDto responseDto = new RestResponseDto();
        idivineService.remove(pmid);
        responseDto.setResult("Delete success");
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("update")
    public ResponseEntity<RestResponseDto> update(@RequestBody PmidKeywordsDto params) {
        RestResponseDto responseDto = new RestResponseDto();
        System.out.println(compressedJson(params));
        String keywordInfo = compressedJson(params);
    
        idivineService.update(params.getPmid(), keywordInfo);
        responseDto.setResult("Update success"); 
        return ResponseEntity.ok(responseDto);
    }

    private String compressedJson(PmidKeywordsDto params){
        return params.getKeywordInfo().replaceAll("\\r\\n|\\r|\\n", "");
        
    }
}
