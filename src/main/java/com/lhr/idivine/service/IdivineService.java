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
    public List<PmidKeywordsDto> findyAll(){
        return idivineMapper.findyAll();
    };

    // pmid로 단건 조회
    public PmidKeywordsDto findByPmid(int pmid){
        return idivineMapper.findByPmid(pmid);

    }

}
