package com.lhr.idivine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.lhr.idivine.dto.PmidKeywordsDto;

import com.lhr.idivine.dto.RestResponseDto;
import com.lhr.idivine.service.IdivineService;

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
    public RestResponseDto getList(@RequestParam("pmid")int pmid){
        RestResponseDto responseDto = new RestResponseDto();
        List<PmidKeywordsDto> list = idivineService.findyAll();
        System.out.println(list);
        return responseDto;
    }
    
    /**
     * keywaord 상세내용
     * @param pmid
     * @return
     */
    @GetMapping("Detail/{pmid}")
    public RestResponseDto detail(@PathVariable("pmid")int pmid){
        RestResponseDto responseDto = new RestResponseDto();
        PmidKeywordsDto dto = idivineService.findByPmid(pmid);
        responseDto.add("keyword", dto);
        return responseDto;
    }
}
