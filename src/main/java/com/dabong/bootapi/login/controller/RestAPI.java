package com.dabong.bootapi.login.controller;

import com.dabong.bootapi.login.vo.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Request 받고 JSON으로 Response 하는 API2
 */
@Slf4j
@RestController
public class RestAPI {

    @GetMapping("/callUser")
    public ResponseEntity<String> callAPI() {

        RestTemplate restTemplate = new RestTemplate();
        String loginUrl = "http://localhost:8011/sendData/post";
        String userName = "테스트";

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("userName", userName);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(loginUrl, parameters, String.class);
        log.info(String.valueOf(responseEntity));
        return responseEntity;
    }

    @GetMapping("/callUser2")
    public ResponseEntity<String> callAPI2(UserVO vo) {

        RestTemplate restTemplate = new RestTemplate();
        String loginUrl = "http://localhost:8011/sendData/post";

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("userName", vo.getUserName());

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(loginUrl, parameters, String.class);
        log.info(String.valueOf(responseEntity));
        return responseEntity;
    }

    /*
    public ResponseEntity<Object> getData(String url ) {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<Object> resultMap = new ResponseEntity<>(null,null,200);

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

            ResponseEntity<?> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //에러처리해야댐
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error");
            System.out.println(e.toString());

            return resultMap;
        }
        catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());

            return resultMap;

        }

        return resultMap;


    }*/
}
