# wireBarley-apply-exchange

wireBarley 환율 계산기 웹 애플리케이션 과제 프로젝트 입니다.

1. Spring boot 기반의 api 모듈과 React 기반의 front 모듈로 나눠 작업하였습니다.
2. front 모듈은 관련 기반 지식이 부족하여 완성하지 못하였습니다.
3. api 모듈의 환율 조회 예시는 다음과 같습니다.
   1. GET http://localhost:8080/exchange?country=USDKRW&amount=199.0
4. api 는 개인 AWS EC2 인스턴스에 구동 중 입니다. 예시는 다음과 같습니다.
   1. http://52.14.14.31:8080/exchange?country=USDKRW&amount=1.0