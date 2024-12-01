package org.example.cruddbstring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository

public class BoardDAO {
    @Autowired
    private JdbcTemplate template;
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    private final String BOARD_INSERT = "insert into BOARD2 (name, author, date) values (?,?,?)";
    private final String BOARD_UPDATE = "update BOARD2 set name=?, author=?, date=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD2 where seq=?";
    private final String BOARD_GET = "select * from BOARD2 where seq=?";
    private final String BOARD_LIST = "select * from BOARD2 order by seq desc";

    // Insert a new board entry
    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        return template.update(BOARD_INSERT,new Object[]{vo.getName(),vo.getAuthor(),vo.getDate()});
    }

    // Update an existing board entry
    public int updateBoard(BoardVO vo) {
        return template.update(BOARD_UPDATE, new Object[]{vo.getName(),vo.getAuthor(),vo.getDate(),vo.getSeq()});
    }

    public List<BoardVO> findAll() {
        String sql = "SELECT * FROM BOARD2"; // 테이블 이름에 맞게 수정
        return template.query(sql, new RowMapper<BoardVO>() {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO boardVO = new BoardVO();
                boardVO.setSeq(rs.getInt("seq"));
                boardVO.setName(rs.getString("name"));
                boardVO.setAuthor(rs.getString("author"));
                boardVO.setDate(rs.getInt("date"));
                return boardVO;
            }
        });
    }

    // 검색 메서드 추가
    public List<BoardVO> searchPosts(String query) {
        String sql = "SELECT * FROM BOARD2 WHERE name LIKE ?";
        List<BoardVO> posts = template.query(sql, new Object[]{"%" + query + "%", "%" + query + "%"},
                new BeanPropertyRowMapper<>(BoardVO.class));
        return posts;
    }

    public BoardVO findById(int seq) {
        try {
            // seq에 해당하는 보드 항목을 조회
            return template.queryForObject(BOARD_GET, new Object[]{seq}, new BeanPropertyRowMapper<>(BoardVO.class));
        } catch (EmptyResultDataAccessException e) {
            // 데이터가 없을 경우 null 반환
            System.out.println("해당 seq에 대한 데이터가 존재하지 않습니다. seq: " + seq);
            return null;  // 또는 예외를 던질 수 있음
        }
    }


    public int deleteBoard(int id) {
        return template.update(BOARD_DELETE,new Object[]{id});
    }

    // Retrieve a specific board entry by its seq
    public BoardVO getBoard(int seq) {
        return template.queryForObject(BOARD_GET,new Object[]{seq},new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }


    // Retrieve a list of all board entries
    public List<BoardVO> getBoardList() {
        return template.query(BOARD_LIST, new RowMapper<BoardVO>() {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO data = new BoardVO();
                data.setSeq(rs.getInt("seq"));
                data.setName(rs.getString("name"));
                data.setAuthor(rs.getString("author"));
                data.setDate(rs.getInt("date"));
                return data;
            }
        });
    }
}
