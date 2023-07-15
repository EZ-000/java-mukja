# Ch1 코딩 테스트 

### 1.3 코딩과 디버깅

```java
import java.util.*;

public class Main {
    // 각 기능별 클래스로 작성!
    private static class PhoneNumber {
        public final String phoneNumber;

        public PhoneNumber(String rawPhoneNumber) {
            this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
        }
        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PhoneNumber)) return false;
            return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
        }
    }

    private static class Person {
        public final String name;
        private final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }
        public void addPhoneNumber(PhoneNumber number) {
            numbers.add(number);
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }
        public boolean hasPhoneNumber(PhoneNumber number) {
            return numbers.contains(number);
        }
    }

    private static class PhoneBook {
        // Set, HashSet을 사용하여 중복 제거 후 출력
        private final Set<Person> people;

        private PhoneBook() {
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            people.add(person);
        }
        
        @Override
        public String toString() {
            return "PhoneBook{" +
                    "people=" + people +
                    '}';
        }
        public Person search(PhoneNumber number) {
            return people.stream()
                    .filter(p -> p.hasPhoneNumber(number))
                    .findFirst()
                    .orElse(null);
        }
    }

    // 메인 코드 실행!
    public static void main(String[] args) {
//        System.out.println(new PhoneNumber("010-1234-5678"));
//        System.out.println(new PhoneNumber("010 1234 5678"));
//        System.out.println(new PhoneNumber("01012345678"));

//        Person person = new Person("홍길동");
//        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//        person.addPhoneNumber(new PhoneNumber("010 1234 5678"));
//        person.addPhoneNumber(new PhoneNumber("01012345678"));
//        System.out.println(person);

//        Person person = new Person("홍길동");
//        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//
//        System.out.println(person.hasPhoneNumber(new PhoneNumber("01012345678")));

//        Person person1 = new Person("홍길동");
//        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));
//
//        Person person2 = new Person("김철수");
//        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));
//
//        Person person3 = new Person("이영희");
//        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));
//
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.addPerson(person1);
//        phoneBook.addPerson(person2);
//        phoneBook.addPerson(person3);
//
//        System.out.println(phoneBook);

//        Person person = new Person("홍길동");
//        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//
//        PhoneBook phoneBook = new PhoneBook();
//        phoneBook.addPerson(person);
//        phoneBook.addPerson(person);
//
//        System.out.println(phoneBook);

        Person person1 = new Person("홍길동");
        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person person2 = new Person("김철수");
        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));

        Person person3 = new Person("이영희");
        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println(phoneBook.search(new PhoneNumber("01023456789")));
        System.out.println(phoneBook.search(new PhoneNumber("01024680246")));
        System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
        System.out.println(phoneBook.search(new PhoneNumber("01000000000")));
    }
}

```

