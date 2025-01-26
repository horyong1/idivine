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
    public void create(int pmid, String keywordInfo){
      idivineMapper.create(pmid, keywordInfo);
    }

    // keywordInfo 삭제
    public void remove(int pmid){
      idivineMapper.remove(pmid);
    }

    public void update(int pmid, String keywordInfo){
      System.out.println("넘어간거야??");
      idivineMapper.update(pmid, keywordInfo);
    }

}
