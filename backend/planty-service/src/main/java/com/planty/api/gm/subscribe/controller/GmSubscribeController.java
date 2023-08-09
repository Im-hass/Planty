package com.planty.api.gm.subscribe.controller;

import com.planty.api.gm.subscribe.response.GmSubscribeResponse;
import com.planty.api.gm.subscribe.service.GmSubscribeService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/greenmates/subscribes")
@RequiredArgsConstructor
@Api
public class GmSubscribeController {

    private final GmSubscribeService gmSubscribeService;

    // 담당 구독 전체 조회
    @GetMapping
    public ResponseEntity<List<GmSubscribeResponse>> findSubscribeList() {
        return new ResponseEntity<List<GmSubscribeResponse>>(gmSubscribeService.findSubscribeList(), HttpStatus.OK);
    }

//    // 담당 구독 상세 조회
//    @GetMapping("/{spid}")
//    public ResponseEntity<?> findSubscribeDetail() {
//        return null;
//    }
//
//    // 구독 사용자 전체 조회
//    @GetMapping("/{spid}/users")
//    public ResponseEntity<?> findSubscriberList() {
//        return null;
//    }
//
//    // 구독 사용자 상세 조회
//    @GetMapping("/{spid}/users/{uid}")
//    public ResponseEntity<?> findSubscriberDetail() {
//        return null;
//    }


}
