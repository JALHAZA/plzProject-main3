package com.lyj.securitydomo.controller;


import com.lyj.securitydomo.domain.Board;
import com.lyj.securitydomo.domain.Request;
import com.lyj.securitydomo.dto.RequestDTO;
import com.lyj.securitydomo.service.BoardService;
import com.lyj.securitydomo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;
    private final BoardService boardService;

    @GetMapping("/apply")
    public String applyForm(@RequestParam("boardId")Long boardId, Model model) {
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);
        return "request/apply";
    }

    @PostMapping("/insert")
    public ResponseEntity<String> saveRequest(@RequestBody RequestDTO requestDTO) {
       try {
           requestService.saveRequest(requestDTO.getPostId(),requestDTO.getTitle(),requestDTO.getContent());
           return ResponseEntity.ok("신청이 완료되었습니다.");
       }catch (IllegalArgumentException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/list")
    public List<RequestDTO> getRequests() {
        return requestService.getRequests();
    }
}

