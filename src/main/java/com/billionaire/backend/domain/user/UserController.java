package com.billionaire.backend.domain.user;

import com.billionaire.backend.domain.portfolio.dto.PortfolioMst;
import com.billionaire.backend.domain.portfolio.services.PortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final PortfolioService portfolioService;

    @GetMapping("/{userNo}/portfolios")
    public ResponseEntity<List<PortfolioMst>> getPortfolioListOfUser(@PathVariable String userNo, @RequestParam(required = false) String planYn) {

        PortfolioMst param = new PortfolioMst();
        param.setUserNo(userNo);
        param.setPlanYn(planYn);
        List<PortfolioMst> result = portfolioService.selectManyPortfolioMst(param);
        return ResponseEntity.ok(result);
    }

}
