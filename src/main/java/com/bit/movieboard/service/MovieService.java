package com.bit.movieboard.service;

import com.bit.movieboard.model.MovieDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "mappers.MovieMapper";
    private final int SIZE = 10;

    // 영화게시판 전체 불러오기
    public List<MovieDTO> selectAll(int pageNo) {
         HashMap<String, Integer> paramMap = new HashMap<>();
         paramMap.put("size", SIZE);
         paramMap.put("stratRow", (pageNo - 1) * SIZE);

         return sqlSession.selectList(NAMESPACE + ".selectAll", paramMap);
    }

    // 영화정보 하나씩 불러오기
    public MovieDTO selectOne(int id) {
        return sqlSession.selectOne(NAMESPACE + ".selectOne", id);
    }

    public void insert(MovieDTO movieDTO) {
        sqlSession.insert(NAMESPACE + ".insert", movieDTO);
    }

    public void update(MovieDTO movieDTO) {
        sqlSession.update(NAMESPACE + ".update", movieDTO);
    }

    public void delete(int id) {
        sqlSession.delete(NAMESPACE + ".delete", id);
    }

    // 메인 영화목록 최대 수 세기
    int countMax() {
        int maxRow = sqlSession.selectOne(NAMESPACE + ".count");
        return maxRow % SIZE == 0 ? maxRow / SIZE : maxRow / SIZE + 1;
    }
}
