package com.lhr.idivine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.lhr.idivine.dto.PmidKeywordsDto;
import com.lhr.idivine.mapper.IdivineMapper;
@Service
public class IdivineService {

    @Autowired
    private IdivineMapper idivineMapper;

    // 리스트 조회
    public List<PmidKeywordsDto> findyAll(String searchType, String searchValue){
        if(searchType.equals("pmid")){
          return idivineMapper.findByPmidList(searchValue);
        }

        if(searchType.equals("text")){
          return idivineMapper.findyByTextList(searchValue);
        }

        return idivineMapper.findyAll();
    };

    // pmid로 단건 조회
    public PmidKeywordsDto findByPmid(int pmid){
        return idivineMapper.findByPmid(pmid);
    }

    // keywordInfo 추가
    public int create(int pmid, String keywordInfo){
      return idivineMapper.create(pmid, keywordInfo);
    }

    // keywordInfo 삭제
    public int remove(int pmid){
      return idivineMapper.remove(pmid);
    }

    // keywordInfo 업데이트
    public int update(int pmid, String keywordInfo){
      return idivineMapper.update(pmid, keywordInfo);
    }

}
