package org.example.cruddbstring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired

    BoardDAO boardDAO;
    BoardVO boardVO;

    public int insertBoard(BoardVO vo) {
        return boardDAO.insertBoard(vo);
    }
    public int updateBoard(BoardVO vo) {
        return boardDAO.updateBoard(vo);
    }
    public int deleteBoard(int id) {
        return boardDAO.deleteBoard(id);
    }
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }
    public  BoardVO getBoard(int id) {
        return boardDAO.getBoard(id);
    }
    public List<BoardVO> findAll() {
        return boardDAO.findAll();
    }
    public List<BoardVO> searchPosts(String query) {
        return boardDAO.searchPosts(query); // DAO에서 검색 수행
    }
    public BoardVO findById(int id){return boardDAO.findById(id);}

}
