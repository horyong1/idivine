package com.lhr.idivine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lhr.idivine.dto.PmidKeywordsDto;

@Mapper
public interface IdivineMapper {


    // 리스트 조회
    List<PmidKeywordsDto> findyAll();
    
    // 텍스트 기준 리스트 조회
    List<PmidKeywordsDto> findyByTextList(String searchValue);
    
    // pmid 기준 리스트 조회
    List<PmidKeywordsDto> findByPmidList(String searchValue);
    
    /// pmid 기준 상세 보기 조회
    PmidKeywordsDto findByPmid(int pmid);
    
    // 생성
    void create(@Param("pmid") int pmid, @Param("keywordInfo") String keywordInfo);
    
    // 삭제
    void remove(int pmid);

    // 수정
    void update(@Param("pmid") int pmid, @Param("keywordInfo") String keywordInfo);
} 
