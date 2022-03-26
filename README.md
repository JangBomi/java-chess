# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 1단계

### 입력

- [x] 게임 시작할때 start를 입력받는다.
- [x] 게임 종료할때 end를 입력받는다.
    - [x] start와 end가 아닌 입력이 들어오면 예외가 발생한다.

### 게임

- [x] 체스판을 만든다.
- [x] 체스 말들을 체스판 위에 초기화시킨다. 말이 없으면 `.`으로 초기화 시킨다.

### 출력

- [x] 체스판을 출력한다.
    -  [x] 말이 있는 위치는 알파벳으로 표현한다.

## 2단계

### 입력

- [x] 말을 움직일때는 move`(source위치 target위치)`를 입력받는다.
    - [x] 체스판을 벗어나는 위치가 입력되면 예외가 발생한다.
    - [x] move 입력 형식과 다른 경우 예외가 발생한다.
    - [x] start를 입력한 후에 move가 입력되어야 한다.

### 게임

- [x] 말이 움직이면 source위치는 `.`이 되고 target위치에 말이 표시된다.
- [x] `나이트`를 제외한 말들은 앞에 말들이 있으면 뛰어넘을 수 없다.
- [x] 규칙에 벗어난 말들의 움직임은 예외가 발생한다.

### 폰

- [x] 폰은 처음 시작할 때, 한칸 또는 두 칸 움직일수 있다.
- [x] 폰은 상대 말을 잡을 때, 대각선 한칸만 움직여서 잡을수 있다.
- [x] 처음 움직임 이후로는 한 칸만 움직일 수 있다.
- [x] 뒤로 움직일 수 없다.

### 룩

- [x] 상하좌우로 칸수 제한없이 움직인다.

### 나이트

- [x] 앞으로 두칸 전진하고 좌 또는 우로 한칸 움직인다.
    - [x] 앞에 말들이 있어도 뛰어넘을수 있다.

### 비숍

- [x] 대각선으로만 칸수 제한없이 움직인다.

### 퀸

- [x] 상하좌우, 대각선 칸수 제한없이 움직인다.

### 킹

- [x] 상하좌우, 대각선 한 칸만 움직일수 있다.

## 3단계

### 게임

- [ ] 킹이 죽거나 end를 입력하면 게임이 끝난다.
- [ ] 남아있는 말에 대해서 점수를 계산한다.
- [ ] 게임이 끝나고 `status`를 입력하면 결과를 보여주고 우승 팀을 알려준다.
- [ ] 게임이 끝나고 아무키나 입력하면 그냥 종료된다.
