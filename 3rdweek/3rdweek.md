### 1. 컬렉션 프레임워크
- 컬렉션 프레임워크란, **데이터 군(group)을 다루고 표현하기 위한 단일화** 된 구조라고 정의한다.
- 컬렉션 프레임워크는 다수의 데이터를 다루는 데에 필요한 다양하고 풍부한 클래스들을 제공하기 때문에 프로그래머의 짐을 상당히 덜어주고 있으며, 또한 인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화되어 있다.
- 때문에, 사용법을 익히기에도 편리하고 재사용성이 높은 코드를 작성할 수 있다는 장점이 있다.


### 2. 컬렉션 프레임워크의 핵심 인터페이스
- 컬렉션 프레임워크에서는 컬렉션 데이터 그룹을 크게 3가지 타입이 존재한다고 인식하고 각 컬렉션을 다루는데 필요한 기능을 가진 인터페이스를 정의했다.
- 그 세 가지 타입은 **List, Set, Map** 이며, 이 중 다시 **List, Set의 공통된 부분을 다시 뽑아서 새로운 인터페이스인 Collction**을 추가로 정의하였다.
- Map 인터페이스는 전혀 다른 형태로 컬렉션을 다룬다.
- 그림으로 나타내면 다음과 같다.
![](https://images.velog.io/images/cil05265/post/99a3e6a1-5a6b-4a0a-9447-b7fdb0bff3db/KakaoTalk_Photo_2021-11-21-02-10-18.jpeg)

### 3. ArrayList
- ArrayList는 컬렉션 프레임워크에서 가장 많이 사용되는 컬렉션 클래스라고 할 수 있다.
- ArrayList는 **List 인터페이스를 구현하기 때문에 데이터의 저장순서가 유지되고 중복을 허용한다는 특징**을 갖는다.
- ArrayList는 Object배열을 이용해서 데이터를 **순차적**으로 저장한다.
- 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성하서 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음에 저장된다.

### 4. ArrayList의 추가와 삭제
- ArrayList의 요소를 삭제하는 경우, **삭제할 객체의 바로 아래에 있는 데이터를 한 칸 씩 위로 복사해서 삭제할 객체를 덮어쓰는 방식**으로 처리한다.
- 만일 삭제할 객체가 마지막 데이터라면, **복사할 필요 없이 단순히 null로 변경**해주기만 하면 된다.
- 배열에 객체를 **순차적으로 저장할 때**와 객체를 **마지막에 저장된 것부터 삭제**하면 **데이터를 옮기지 않아도 되기 때문에 작업시간이 짧다.**
- 다만, 배열의 **중간**에 위치한 객체를 추가하거나 삭제하는 경우 **다른 데이터의 위치를 이동시켜 줘야 하기 때문에** 다루는 데이터의 개수가 **많을수록 작업시간이 오래 걸린다는 것이다.**
![](https://images.velog.io/images/cil05265/post/3c20a040-2d07-4df7-8d22-67b504fcbdbf/KakaoTalk_Photo_2021-11-21-02-53-45.jpeg)


## ArrayList를 사용한 예제

```java
import java.util.*;
class Ex11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));

		ArrayList list2 = new ArrayList(list1.subList(1,4)); 
		print(list1, list2);

		Collections.sort(list1);	// list1과 list2를 정렬한다.
		Collections.sort(list2);	// Collections.sort(List l)
		print(list1, list2);

		System.out.println("list1.containsAll(list2):"
                                               + list1.containsAll(list2));

		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);

		list2.set(3, "AA");
		print(list1, list2);

		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));

		print(list1, list2);

		//  list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i= list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);
	} // main의 끝

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();		
	}
} // class

```

- 출력화면
![](https://images.velog.io/images/cil05265/post/47f4dd77-943a-4f71-9c8c-7cad4044ab6e/%E3%82%B9%E3%82%AF%E3%83%AA%E3%83%BC%E3%83%B3%E3%82%B7%E3%83%A7%E3%83%83%E3%83%88%202021-11-21%203.44.26.png)



### 5. LinkedList
- LinkedList는 배열의 단점을 보완하기 위해 만들어진 자료구조이다.

> 배열은? 가장 기본적인 형태의 자료구조이다. <br>
  장점: 구조가 간단하며 사용하기 쉽고 데이터를 읽어 오는데 걸리는 시간이 빠르다는 장점을 가지고 있다. <Br>
  단점: 크기를 변경할 수 없고 비순차적인 데이터의 추가 또는 삭제에 시간이 많기 걸린다.

- 배열은 모든 데이터가 연속적으로 존재하지만 링크드 리스트는 불연속적으로 존재하는 데이터를 서로 연결하는 형태로 구성되어있다.

### 6. LinkedList의 추가와 삭제
- **삭제의 경우**, 삭제하고자 하는 요소의 이전 요소가 삭제하고자 하는 요소의 다음 요소를 참조하도록 변경하기만 하면 된다.
- **추가의 경우**, 새로운 요소를 생성한 다음 추가하고자 하는 위치의 이전 요소의 참조를 새로운 요소에 대한 참조로 변경해주고, 새로운 요소가 그 다음 요소를 참조하도록 변경하기만 하면 된다.
![](https://images.velog.io/images/cil05265/post/1e53f81e-96fd-4ea7-9452-f2c5d2473814/KakaoTalk_Photo_2021-11-21-03-21-23.jpeg)

### 7. ArrayList와 LinkedList의 비교
| 컬렉션     | 읽기(접근시간)| 추가 / 삭제 | 비고 |
-----------|-----------|-----------|-----------
| ArrayList | 빠르다 | 느리다 | 순차적인 추가삭제는 더 빠름. 비효율적인 메모리사용. |
| Linkedlist  | 느리다 | 빠르다 | 데이터가 많을수록 접근성이 떨어짐.|

- 다루고자 하는 데이터의 개수가 변하지 않는 경우라면 **ArrayList**를 사용하는 것이 좋다.
- 데이터 개수의 변경이 잦다면 **LinkedList**를 사용하는 것이 좋다.


### 8. HashSet
- HashSet은 **Set 인터페이스** 를 구현한 가장 대표적인 컬렉션이며, **Set 인터페이스** 의 특징대로 중복된 요소를 저장하지 않는다.
- ArrayList와 같이 List인터페이스를 구현한 컬렉션과 다르게 **HashSet은 저장순서를 유지하지 않으므로** 저장순서를 유지하고자 한다면 LinkedHashSet을 사용해야 한다.

### 9. TreeSet
- 이진 탐색 트리라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스이다. **이진 탐색 트리는 정렬, 검색, 범위 검색에 높은 성능을 보이는 자료구조** 이다.
- Set인터페이스를 구현했으므로 **중복된 데이터의 저장을 허용하지 않으며 정렬된 위치에 저장하므로 저장 순서를 유지하지도 않는다.**
- **이진 트리**는 링크드 리스트처럼 **여러 개의 노드가 서로 연결된 구조**로, 각 노드에 최대 **2개** 의 노드를 연결할 수 있다.
- 루트라고 불리는 하나의 노드에서부터 시작해서 계속 확장해 나간다.

### 10. 참고문헌
- 남궁성 저, <자바의 정석>









