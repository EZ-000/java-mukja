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



### 진법 바꾸기

#### 문자열과 정수를 변환하는 메서드

| 메서드                     | 반환형 | 내용                                   |
| -------------------------- | ------ | -------------------------------------- |
| Integer.parseInt(String s) | int    | 숫자를 표현하는 문자열 s를 정수로 변환 |
| Integer.toString(int v)    | String | 정수 v를 문자열로 변환                 |
| Long.parseLong(String s)   | long   | 숫자를 표현하는 문자열 s를 정수로 변환 |
| Long.toString(long v)      | String | 정수 v를 문자열로 변환                 |

#### 문자열과 정수를 진법에 따라 변환하는 메서드

| 메서드                                | 반환형 | 내용                                                  |
| ------------------------------------- | ------ | ----------------------------------------------------- |
| Integer.parseInt(String s, int radix) | int    | radix 진법으로 숫자를 표현하는 문자열 s를 정수로 변환 |
| Integer.toString(int v, int radix)    | String | 정수 v를 radix 진법의 문자열로 변환                   |
| Long.parseLong(String s, int radix)   | long   | radix 진법으로 숫자를 표현하는 문자열 s를 정수로 변환 |
| Long.toString(long v, int radix)      | String | 정수 v를 radix 진법의 문자열로 변환                   |

##### 진법 바꾸기 사용 예시

```java
String binary = "1010";
int value = Integer.parseInt(binary, 2);       // value = 10
String hex = Integer.toString(value, 16);      // hex = a
```



### 찾기와 바꾸기

#### 포함 여부를 검사하는 메서드

| 메서드                    | 반환형  | 내용                                                         |
| ------------------------- | ------- | ------------------------------------------------------------ |
| contains(CharSequence s)  | boolean | 전달받은 문자열이 원본 문자열에 있는지 검사                  |
| startsWith(String prefix) | boolean | 원본 문자열이 전달받은 문자열로 시작하는지 검사              |
| endsWith(String suffix)   | boolean | 원본 문자열이 전달받은 문자열로 끝나는지 검사                |
| indexOf(String str)       | int     | 전달받은 문자열이 원본 문자열에서 몇 번째 인덱스에 있는지 검사 |

#### 문자열 치환 메서드

| 메서드                                                 | 반환형 | 내용                                                         |
| ------------------------------------------------------ | ------ | ------------------------------------------------------------ |
| replace(char oldChar, char newChar)                    | String | 원본 문자열의 oldChar 문자들을 newChar 문자로 치환한 문자열을 반환 |
| replace(CharSequence target, CharSequence replacement) | String | 원본 문자열에서 등장하는 target 문자열을 replacement 문자열로 치환해서 반환하는 메서드 |

**CharSequence는 문자열을 나타내는 인터페이스
 String 클래스도 CharSequence 인터페이스를 구현하고 있기 때문에 일반적인 문자열과 같다고 생각해도 무방



### 정규표현식

: 문자열 패턴을 나타내는 표현 방식

- 복잡한 문자열도 쉽게 검색할 수 있습니다. 
- 유용한 만큼 내용이 많고 제대로 다루기 쉽지 않습니다. 
- 많은 경우 정규표현식을 대체할 수 있는 자바의 내장 라이브러리가 있고, 이를 이용하는 것이 편리합니다.

#### 자주 사용되는 정규표현식

| 정규표현식 | 내용                                                         | 예시                                                       |
| ---------- | ------------------------------------------------------------ | ---------------------------------------------------------- |
| .          | 개행 문자를 제외한 아무 문자                                 | .nd -> and, end, cnd, nnd, …                               |
| [abc]      | a, b, c 중 아무것이나                                        | [ae]nd -> and, end                                         |
| [^abc]     | a, b, c를 제외하고                                           | [^ae]nd -> cnd, nnd, …                                     |
| [a-g]      | a, g 사이의 문자들[0-9] -> 모든 숫자[a-z] -> 모든 소문자[A-Z] -> 모든 대문자 | [1-9][0-9] -> 10, 25, 88, 99, …[A-Z][a-z] -> An, By, Hi, … |
| a*         | a 0개 이상                                                   | 1[0-9]* -> 1, 10, 164, 1810, …                             |
| a+         | a 1개 이상                                                   | 1[0-9]+ -> 10, 164, 1810, …                                |
| a?         | a 0개 또는 1개                                               | 1[0-9]? -> 1, 11, 15, 19, …                                |
| a{5}       | a 5개                                                        | [a-c]{3} -> aaa, aab, aac, aba, abb, …, ccb, ccc           |
| a{2,}      | a 2개 이상                                                   | [a-c]{3,} -> a, aa, ab, ac, aaa, …, ccc                    |
| a{2, 4}    | a 2개 이상 4개 이하                                          | [a-c]{2, 3} -> aa, aab, aac, ab, aba, …, ccc               |
| ab\|cd     | ab 또는 cd                                                   | 일\|하나\|한 -> 일, 하나, 한, …                            |
| ^a         | 문자열의 처음 문자가 a                                       |                                                            |
| a$         | 문자열의 마지막 문자가 a                                     |                                                            |
| \          | 사전 정의된 문자를 표현하는 이스케이프 시퀀스                | \. -> .\+ -> +                                             |

#### String 클래스의 정규표현식 관련 메서드

| 메서드                                       | 반환형   | 내용                                                         |
| -------------------------------------------- | -------- | ------------------------------------------------------------ |
| replaceAll(String regex, String replacement) | String   | 전달받은 정규표현식에 매칭되는 패턴을 모두 replacement로 치환 |
| matches(String regex)                        | boolean  | 문자열이 전달받은 정규표현식에 매칭되는지 여부를 반환        |
| split(String regex)                          | String[] | 전달받은 정규표현식에 매칭되는 패턴을 기준으로 원본 문자열을 잘라서 반환 |

##### 정규표현식 사용 예시

```java
//문자열에 소문자가 몇 번 등장하는지 모르기 때문에 *로 정규표현식을 구성
boolean matches("[a-z]*");
```

