package com.lhr.idivine.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.lhr.idivine.dto.PmidKeywordsDto;

@Mapper
public interface IdivineMapper {

    // 리스트 조회
    List<PmidKeywordsDto> findyAll();
    PmidKeywordsDto findByPmid(int pmid);
} 
