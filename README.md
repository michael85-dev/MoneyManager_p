## MoneyManager project
- 가계부 기능을 하는 홈페이지 제작

----
## 기능 설명

Client : 계좌 정보를 고객마다 다르게 관리하기 위한 기능
- 첨부 기능
    - 회원가입(Join) : 회원 가입 양식을 통해 회원가입
        - 아이디 중복 확인
        - 비밀번호 두 번 입력을 통해 재화인
        - 정규식을 통해 비밀번호 정규 화

    - 로그인(Login)
        - 회원 가입을 통해 저장된 데이터 베이스에서 아이디 검색 


Account : 계좌 정보를 기록 하기 이전에 분류
- 첨부 기능
    - 은행 정보(Bank) : 계좌 생성 이전에 은행별 분류를 통해 정보 정리를 편하게 하기 위함
    - 자산(tAsset) : 하위 연동 계좌들의 자산을 통합하여 해당 은행에 얼마가 있는지 정리 하기 위함
    - 메모(memo) : 은행별 특색 등을 기록하기 위함
    - 사진(photo) : 은행 이미지 기록하기 위함

AccountInfo : 계좌 정보를 기록
- 첨부 기능
    - 계좌 정보(Account) : 연동된 은행 안에 관련 계좌를 생성할 때 저장 하기 위한 항목
    - 자산(pAsset) : 해당 계좌에 총 얼마가 있는지 확인하기 위함
    - 메모(memo) : 해당 계좌의 속성 확인
    - 이율(iRate) : 계좌 금리를 적을 시 월마다 또는 년마다 이자가 붙게 설정 (해당 기능 미구현)
    - 사진(photo) : 계좌의 이미지를 보기 쉽게 표현 하기 위함

AccountContents : 계좌의 내역을 기재
- 첨부 기능
    - 내역(name) : 연동된 계좌의 사용 내역을 기록
    - 사용 내역(pAsset) : +에 대한 항목을 기록
    - 사용 내역(mAsset) : -에 대한 항목을 기록
    - 메모(memo) : 해당 계좌의 메모 확인
    - 사진(photo) : 내역 기록시 영수증을 저장하기 위함

Card : 카드 정보를 기록하기 이전에 분류
- 첨부 기능
    - 카드사 정보(Card) : 카드 생성 이전에 분류를 쉽게 하기 위함
    - 사용액(tAsset) : 카드별 총 사용액 확인을 위함
    - 메모(memo) : 카드사별 정보 기록을 위함
    - 사진(photo) : 카드사 이미지 기록을 위함

CardInfo : 카드별 정보 기록
- 첨부 기능
    - 카드정보(name) : 카드사에서 만든 카드 정보를 분류 하기 위함
    - 카드 세부정보(info) : 체크카드 신용카드 여부 확인
    - 메모(memo) : 카드 해택등 메모를 하기 위함
    - 사진(photo) : 카드 이미지 기록을 위함
    <미구현>
    - 날짜 : 신용카드의 경우 1개월 마다 자동 이체 되게 설정해야하는데 해당 항목에 대해서 고안을 하지 않고 작성을 시작함.

CardContents : 카드 내역 기록
- 첨부 기능
    - 내역(name) : 사용 내역 기록
    - 세부사항(info) : 할부 정보 기록
    - 메모(memo) : 내역에 대한 상세 사항 기록
    - 사진(photo) : 영수증 기록

Cash : 현금에 대한 분류
- 첨부 기능
    - 계좌(name) : 현금 계좌 
    - 메모(memo) : 현금 계좌 정보 기록
    - 사진(photo) : 현금 계좌에 대한 정보 (불필요)

CashInfo : 현금 사용 내역 기록
- 첨부 기능
    - 내여(name) : 현금 사용 에 대한 내역 기록
    - 메모(memo) : 현금 사용 내역 세부 사항 기록
    - 사진(photo) : 현금 사용에 대한 영수증 기록

----
## 보안 필요 점
1. jsp 페이지에서 +와 - 에 대한 값을 select로 하여 value 값을 주었을 경우 해당 값이 제대로 name(mAsset, pAsset)에 맞지 않게 기록이 도거나 기록되지 않는 형상이 발생함

2. 모든 계좌 및 카드 값 표현
    - 1번과 비슷한 항목인데 실제 전체적인 값을 표현하더라도 해당 선택 계좌에 값이 제대로 기록이 안됨

3. 계좌 또는 카드 등 간에 이체 방식
    - 이체 항목 선택시 제대로 선택이 안됨
    - 이체 항목 선택 후 입 출금에 대한 항목 선택이 명확하지 않음

4. 1,2,3 번이 해결되지 않기에 도표화 값을 적용하지 않음
    - 1,2,3이 해결되면 바로 적용 가능.

5. 너무 복잡하게 생각한 것이 아닌가 싶음
    - 실제 코딩을 하는 날짜가 오류를 수정하기 위해 날린 3일을 제외하고 6일 정도밖에 되지 않음
    - 실제 기본적인 틀을 짜는데 소비된 것 외에 해당 값들을 찾지 못해 4~5일 정도를 소비함.

----
## 향후 계획
1. 해당 홈페이지 완성
    - 실제 개인적으로 사용하기 위해서 만드는 것이므로 모바일화 할 수 있도록 고안 필요
    - 전체적인 구성을 다시 짜는 것이 필요함.
2. 개인적으로 사용을 통해 데이터 누적화
    - Excel로 어떻게 파일화 할 수 있을지 방법 고안