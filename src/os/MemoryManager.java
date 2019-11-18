package os;

public class MemoryManager {
	/*
	 * 주소 바인딩
	 * 프로그래밍 할 때 변수명-논리적인 주소
	 * 자바에서 클래스는 모듈-다른 언어에서는 아닐 수 있다.
	 * 모듈-독립된 파일-컴파일 가능한
	 * 컴파일-모듈에서의 상대주소로 정한다.-독립적 모듈을 기계어로 변환한다.
	 * 링크-모듈끼리 연결한다.-exe에서의 상대주소
	 * 로드-절대주소
	 * exe는 놔두고 세그먼트 레지스터로 조정한다.
	 * 함수호출-스택에 액티베이션 레코드-콜스택
	 * main에서 쓰는거는 static변수-데이터 세그먼트
	 * new는 heap메모리
	 * 함수안에 있는거는 호출 될 때 할당
	 * 액티베이션 레코드-호출한 ar, 돌아갈 주소, 파라미터, 지역변수
	 * IR이 명령어 하나가 아니라 여러 개를 가져온다.-ir이 여러 개
	 * relocation register-메모리 매니지먼트 유닛
	 * 세그먼트 상대주소->프로세스 상대주소->물리주소
	 * 실행 시에 os가 메모리에 올려준다.-dll
	 * 다른 라이브러리는 컴파일 시 링크 되거나 dll로 함수 실행 시 로딩 됨
	 * 디스패처-실제 프로세스를 실행시켜주는 애
	 * 세그먼트=페이지
	 * 세그먼트를 나눌 때 각 세그먼트의 사이즈랑 시작주소를 저장하는 테이블-리밋 레지스터, 베이스 레지스터
	 * */

}
