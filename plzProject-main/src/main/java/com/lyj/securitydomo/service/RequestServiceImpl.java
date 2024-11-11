package com.lyj.securitydomo.service;

import com.lyj.securitydomo.domain.Request;
import com.lyj.securitydomo.domain.RequestStatus;
import com.lyj.securitydomo.dto.RequestDTO;
import com.lyj.securitydomo.repository.RequestRepository;
import com.lyj.securitydomo.repository.RequestStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final RequestStatusRepository requestStatusRepository;

    @Override
    public List<RequestDTO> getRequests(){
        return requestRepository.findAllRequestWithUserAndPostContent();
    }

    @Override
    public void saveRequest(Request request){
//        // "진행중" 상태를 조회하여 설정
//        RequestStatus inProgressStatus = requestStatusRepository.findById(1L)// 1L은 "진행중"의 ID
//                .orElseThrow(()->new IllegalArgumentException("진행중 상태가 없습니다"));
//        request.setRequestStatus(inProgressStatus);// 기본 상태로 "진행중" 설정
//
//        // 로그 추가
//        System.out.println("Saving request: " + request);
//        System.out.println("With status: " + inProgressStatus);

        requestRepository.save(request); // Request 저장
    }


//    // 완료 상태로 업데이트
//    public void markRequestAsCompleted(Long requestId) {
//        Request request = requestRepository.findById(requestId)
//                .orElseThrow(() -> new IllegalArgumentException("Request not found with id: " + requestId));
//        RequestStatus completedStatus = requestStatusRepository.findById(2L)
//                .orElseThrow(() -> new IllegalArgumentException("완료 상태가 없습니다."));
//        request.setRequestStatus(completedStatus);
//        requestRepository.save(request);
//    }
}
