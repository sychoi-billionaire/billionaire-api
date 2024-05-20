package com.billionaire.backend.domain.acc;

import com.billionaire.backend.domain.acc.dto.AccMst;
import com.billionaire.backend.domain.acc.services.AccService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccController {
    private final AccService accService;

    @GetMapping("/{accNo}")
    public ResponseEntity<AccMst> getAccMstWithAccNo(@PathVariable long accNo){
        AccMst accMst = AccMst.builder()
                                .accNo(accNo)
                                .build();
        AccMst result = accService.selectAccountWithAccNo(accMst);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{accNo}")
    public ResponseEntity<AccMst> updateAccMstWithAccNo(@PathVariable long accNo, @RequestBody AccMst accMst){
        accMst.setAccNo(accNo);

        AccMst updateResult = accService.updateAccountWithAccNo(accMst);
        return ResponseEntity.ok(updateResult);
    }
}
