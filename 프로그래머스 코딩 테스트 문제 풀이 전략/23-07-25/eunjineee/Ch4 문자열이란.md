# Ch4 문자열이란?

## 4.1 문자열의 특징

 ### 문자의 배열

``` java
String.charAt(int index)    //주어진 인덱스에 있는 문자를 char형식으로 반환
String.toCharArray()        //모든 문자가 들어있는 char[]형식의 데이터 반환
```

| 구분   | String.charAt(int index)                | String.toCharArray()                          |
| ------ | --------------------------------------- | --------------------------------------------- |
| 장점   | 문자 하나를 쉽게 가져올 수 있다.        | 모든 문자를 한 번에 가져올 수 있다.           |
| 단점   | 메서드 호출에 따른 오버헤드가 있다.     | 문자열 길이에 해당하는 메모리를 사용한다.     |
| 사용처 | 특정 몇 개의 문자만 필요할 때 사용한다. | 문자열의 모든 문자 정보가 필요할 때 사용한다. |



### 아스키 코드

숫자를 표현하는 문자의 아스키 코드

| 문자        | '0'  | '1'  | '2'  | '3'  | '4'  | '5'  | '6'  | '7'  | '8'  | '9'  |
| ----------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 아스키 코드 | 48   | 49   | 50   | 51   | 52   | 53   | 54   | 55   | 56   | 57   |

내장 라이브 러리  : `Character.getNumericValue(digit)`



#### 문자를 정수로 바꾸는 방법

``` java
char digit = '9';
//문자에서 아스키코드를 빼면 해당 문자가 표현하는 정수 값이 나옴
int digitToInt = digit - '0';
//내장 라이브러리 이용
int digitToInt = Character.getNumericValue(digit);
```



#### 대문자 ⇄ 소문자 바꾸는 방법

```java
// 소문자 → 대문자

char lower = 'e';
//소문자와 대문자 차이 = 'a' - 'A'
char upper = (char) (lower + ('a'-'A'));
//내장 라이브러리 이용
char upper = Character.toUpperCase(lower);


// 대문자 → 소문자

char upper = 'G';
//소문자와 대문자 차이 = 'a' - 'A'
char lower = (char) (upper - ('a'-'A'));
//내장 라이브러리 이용
char lower = Character.toLowerCase(upper);
```



### StringBuilder

```java
String az = "";
for (char c = 'a'; c <= 'z'; c++) {
    az += c;
}
System.out.println(az); // "abcd..xyz"
```

▲ 문자열을 하나씩 이어 붙이는 형태의 코드

매번 새로운 문자열 객체 생성 + 새로운 문자의 배열 복사 (모든 원소를 참조) =>  **시간 복잡도 O(N²)**

StringBuilder 클래스는 내부 배열에서 직접 수정 => **기대 시간 복잡도 O(1)** **= 시간 복잡도 O(N)**



#### 자주 사용되는 StringBuilder의 메서드

| 메서드                       | 역할                                               | 시간 복잡도 |
| ---------------------------- | -------------------------------------------------- | ----------- |
| StringBuilder.toString()     | 지금까지 구성한 문자열을 String 형식으로 반환한다. | O(N)        |
| StringBuilder.append(char c) | 문자 c를 문자열 끝에 이어 붙인다.                  | O(1)        |
| StringBuilder.length()       | 지금까지 구성한 문자열 길이를 반환한다.            | O(1)        |
| StringBuilder.reverse()      | 지금까지 구성한 문자열을 뒤집는다.                 | O(N)        |



#### StringBuilder 사용 예시

'a'부터 'z'까지 문자열 이어붙이기

```java
StringBuilder azBuilder = new StrinfBuilder();
for (char c = 'a'; c <= 'z'; c++){
    azBuilder.append(c);
}
String az = azBuilder.toString();
System.out.println(az);
```

각 반복문에서 O(1)의 시간 복잡도를 가지기 때문에 O(N) 시간이 걸림



## 4.2 문자열 다루어 보기

#### Sring 클래스에서 자주 사용되는 메서드

| 메서드                                  | 반환형  | 내용                                             |
| --------------------------------------- | ------- | ------------------------------------------------ |
| equals(String other)                    | boolean | 문자열이 other와 같은 문자열을 담고 있는지 반환  |
| length()                                | int     | 문자열 길이를 반환                               |
| substring(int beginIndex, int endIndex) | String  | 문자열의 beginIndex부터 endIndex까지 잘라서 반환 |
| toUpperCase()                           | String  | 모든 알파벳이 대문자로 변환된 문자열을 반환      |
| toLowerCase()                           | String  | 모든 알파벳이 소문자로 변환된 문자열을 반환      |

** 문자열은 객체이기 때문에 `equals()`를 사용해야 함 (`==` ~~사용 불가~~)

