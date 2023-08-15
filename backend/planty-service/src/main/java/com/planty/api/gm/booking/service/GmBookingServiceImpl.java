package com.planty.api.gm.booking.service;

import com.planty.api.booking.response.BookingResponse;
import com.planty.api.gm.booking.response.GmBookingResponse;
import com.planty.common.exception.handler.ExceptionHandler;
import com.planty.common.util.SecurityUtil;
import com.planty.db.entity.ConsultingBooking;
import com.planty.db.entity.GmInfo;
import com.planty.db.entity.ViewUserConsulting;
import com.planty.db.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.planty.common.util.LogCurrent.*;
import static com.planty.common.util.LogCurrent.START;

@Slf4j
@Service
@RequiredArgsConstructor
public class GmBookingServiceImpl implements GmBookingService {

    private final GmInfoRepository gmInfoRepository;
    private final ConsultingBookingRepository consultingBookingRepository;
    private final SubscribeProductRepository subscribeProductRepository;

    @Override // 그린메이트 예약 조회
    public List<GmBookingResponse> getGmBooking(Long spid) {
        log.info(logCurrent(getClassName(), getMethodName(), START));
        Long gid = SecurityUtil.getCurrentGid();
        GmInfo gm = gmInfoRepository.findByGid(gid)
                .orElseThrow(() -> new NullPointerException(ExceptionHandler.GM_NOT_FOUND));
        boolean isSpid = true;
        if (spid == null) {
            isSpid = false;
        }
        if (isSpid) {   // 유효한 spid에 대한 요청인지 확인
            subscribeProductRepository.findBySpid(spid)
                    .orElseThrow(() -> new NullPointerException(ExceptionHandler.PRODUCT_NOT_FOUND));
        }

        List<GmBookingResponse> bookingList = new ArrayList<>();
        List<ConsultingBooking> list = consultingBookingRepository.findByGidAndActiveAndCancel(gm, false, false);
//        if (spid == null) {
//            list = consultingBookingRepository.findByGid(gm);
//        } else {
//            list = consultingBookingRepository.findByGid(gm);
//        }
        for (ConsultingBooking item : list) {
            if (isSpid && item.getSid().getSpid().getSpid() != spid) {
                continue;
            }
            GmBookingResponse booking = GmBookingResponse.builder()
                    .sid(item.getSid().getSid())
                    .cid(item.getCid())
                    .title(item.getSid().getSpid().getName())
                    .date(item.getDate())
                    .time(item.getTimeIdx().getIdx())
                    .greenmate(item.getGid().getNickname())
                    .user(item.getUid().getUserName())
                    .build();
            bookingList.add(booking);
        }
        return bookingList;
    }
}