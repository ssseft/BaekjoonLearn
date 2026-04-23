# [Gold II] LCS Making - 33995 

[문제 링크](https://www.acmicpc.net/problem/33995) 

### 성능 요약

메모리: 22908 KB, 시간: 316 ms

### 분류

문자열, 애드 혹

### 제출 일자

2026년 04월 23일 10:28:03

### 문제 설명

<p>어떤 두 수열의 최장 공통 부분 수열(Longest Common Subsequence, 이하 $\text{LCS}$)은 두 수열 모두의 부분 수열이 되는 수열 중 가장 긴 것을 말한다. 예를 들어, abcdef와 agcaxf의 $\text{LCS}$는 acf가 된다.</p>

<p>$\text{LCS}$와 관련된 문제를 내고 싶던 Vermeil은 테스트 케이스를 만드는 과정에서 난관에 봉착했다. 알파벳 소문자로만 이루어진 길이 $N$의 문자열 $S$가 있을 때, $\text{LCS}(S, T)$의 길이가 $K$가 되도록 하는 문자열 $T$를 찾으려 한다. 이때 $T$는 알파벳 소문자로만 이루어져야 하며, 문자열 $S$와 $T$의 길이는 같아야 한다. $N$과 $K$, 그리고 문자열 $S$가 주어질 때, 찾으려는 문자열 $T$가 존재하는지의 여부를 Vermeil에게 알려주자.</p>

### 입력 

 <p>첫 번째 줄에 정수 $N$, $K$가 공백으로 구분되어 주어진다. $(1 \leq K \leq N \leq 200\ 000)$</p>

<p>두 번째 줄에 알파벳 소문자로만 이루어진 길이 $N$의 문자열 $S$가 주어진다.</p>

### 출력 

 <p>$|\text{LCS}(S, T)| = K$를 만족하는 $T$가 존재한다면 <span style="color:#e74c3c;"><code>1</code></span>을, 존재하지 않는다면 <span style="color:#e74c3c;"><code>0</code></span>을 출력한다. 이때 $|\text{LCS}(S, T)|$는 $\text{LCS}(S, T)$의 길이이다.</p>

