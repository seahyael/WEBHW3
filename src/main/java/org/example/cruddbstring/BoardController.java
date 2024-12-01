package org.example.cruddbstring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 목록 조회
    @GetMapping("/list")
    public String boardlist(Model model) {
        model.addAttribute("list", boardService.getBoardList());
        return "posts"; // posts.jsp 페이지로 이동
    }

    // 게시글 추가 폼
    @GetMapping("/add")
    public String addPost() {
        return "addpostform"; // addpostform.jsp 페이지로 이동
    }

    // 게시글 추가 처리
    @PostMapping("/addok")
    public String addPostOK(BoardVO vo, Model model) {
        int result = boardService.insertBoard(vo);
        if (result == 0) {
            model.addAttribute("error", "데이터 추가 실패");
        } else {
            model.addAttribute("success", "데이터 추가 성공!!!");
        }
        return "redirect:/list"; // 목록 페이지로 리다이렉트
    }

    // 게시글 수정 폼
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("boardVO", boardVO);
        return "editform"; // editform.jsp 페이지로 이동
    }

    // 게시글 상세보기 요청 처리
    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.findById(id); // 게시물 조회
        model.addAttribute("u", boardVO); // 모델에 게시물 추가
        return "view"; // view.jsp로 이동
    }

    // 게시글 수정 처리
    @PostMapping("/editok")
    public String editPostOK(BoardVO vo, Model model) {
        int result = boardService.updateBoard(vo);
        if (result == 0) {
            model.addAttribute("error", "데이터 수정 실패");
        } else {
            model.addAttribute("success", "데이터 수정 성공!!!");
        }
        return "redirect:/list"; // 목록 페이지로 리다이렉트
    }

    // 게시글 삭제 처리
    @GetMapping("/deleteok/{id}")
    public String deletePost(@PathVariable("id") int id, Model model) {
        int result = boardService.deleteBoard(id);
        if (result == 0) {
            model.addAttribute("error", "데이터 삭제 실패");
        } else {
            model.addAttribute("success", "데이터 삭제 성공!!!");
        }
        return "redirect:/list"; // 목록 페이지로 리다이렉트
    }


        // 검색 요청 처리
        @RequestMapping(value = "/search", method = RequestMethod.GET)
        public String search(@RequestParam("query") String query, Model model) {
            // 검색어를 포함하는 게시물 목록 가져오기
            List<BoardVO> searchResults = boardService.searchPosts(query);
            model.addAttribute("list", searchResults); // 검색 결과를 모델에 추가
            return "posts"; // 게시물 목록 페이지로 이동
        }
}
