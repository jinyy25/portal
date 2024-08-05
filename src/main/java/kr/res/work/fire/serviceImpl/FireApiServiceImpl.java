package kr.res.work.fire.serviceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


import kr.res.work.fire.dto.FireRequestDto;

import kr.res.work.fire.service.FireApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.ws.rs.POST;


@Service
public class FireApiServiceImpl implements FireApiService {

     private static final Logger log = LoggerFactory.getLogger(FireApiServiceImpl.class);
     private final WebClient.Builder webClient;

     public FireApiServiceImpl(WebClient.Builder webClient) {
      this.webClient = webClient;
     }


     @Override
     @CircuitBreaker(name="addInfo", fallbackMethod="addInfoFallback")
     public String addInfo(FireRequestDto fireRequestDto){

        return webClient.build().post()
        //            .uri("http://localhost:8080/customer/customers/" + customerId)
        //           .uri("http://localhost:8111/api/search/add")
                    .uri("http://fire/api/search/add")
                    .body(Mono.just(fireRequestDto), FireRequestDto.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .flux()
                    .toStream()
                    .findFirst()
                    .orElse(null);
         }


      public String addInfoFallback(FireRequestDto fireRequestDto, Throwable ex) {
          log.info("Error:" + ex.getMessage());
          return "고객정보 조회가 지연되고 있습니다.";
      }
}

//@Service
//public class CustomerApiServiceImpl implements CustomerApiService {
//
//	private static final Logger log = LoggerFactory.getLogger(CustomerApiServiceImpl.class);
//	private final WebClient.Builder webClient;
//
//	public CustomerApiServiceImpl(WebClient.Builder webClient) {
//		this.webClient = webClient;
//	}
//
//	@Override
//	//@CircuitBreaker(name="getCustomerDetail", fallbackMethod="getCustomerDetailFallback")
//	public String getCustomerDetail(String customerId) {
//		//return customerId;
//    	return webClient.build().get()
//    			.uri("http://localhost:8080/customer/customers/" + customerId)
//    			.retrieve()
//    			.bodyToMono(String.class)
//    			.flux()
//    			.toStream()
//    			.findFirst()
//    			.orElse(null);
//	}
//
//	public String getCustomerDetailFallback(String customerId, Throwable ex) {
//		log.info("Error:" + ex.getMessage());
//		return "고객정보 조회가 지연되고 있습니다.";
//	}
//
//}
