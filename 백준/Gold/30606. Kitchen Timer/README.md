# [Gold III] Kitchen Timer - 30606 

[문제 링크](https://www.acmicpc.net/problem/30606) 

### 성능 요약

메모리: 20556 KB, 시간: 212 ms

### 분류

수학, 그리디 알고리즘

### 제출 일자

2026년 04월 23일 10:28:03

### 문제 설명

<p>Kenny has a microwave in his kitchen. The microwave has a pretty weird one-button timer interface. </p>

<p>When you have put some food into the microwave and want it to start heating, you should press the button one or multiple times. When you press the button for the first time, the timer is set for $1$ minute. If you immediately press the button again, $2$ minutes are added to the timer, for a total of $3$ minutes. If you immediately press the button yet again, $4$ more minutes are added to the timer, and so on. If you press the button for the $k$-th time without a pause, it adds $2^k$ minutes to the timer.</p>

<p>It seems impossible to set the timer for some periods of time by using the button: for example, how to set the timer for $2$ minutes? Fortunately, you can reset the button counter by making a pause for one second. So, for example, if you press the button, make a pause for one second, and then press the button again, the timer is set for $2$ minutes. Another example: if you press, press, pause, press, press, press, the total time on the timer is $1+2+1+2+4=10$ minutes.</p>

<p>Kenny needs to heat his food for exactly $x$ minutes. Help him to find the minimum number of one-second pauses he needs to set the timer. Let us assume that only pauses take time, while time to press the button is ignored.</p>

### 입력 

 <p>Each test contains multiple test cases. The first line contains the number of test cases $t$ ($1 \le t \le 10^4$). The description of the test cases follows.</p>

<p>The only line of each test case contains a single integer $x$, denoting the number of minutes Kenny needs to heat the food for ($1 \le x \le 10^{18}$).</p>

### 출력 

 <p>For each test case, print a single integer, denoting the minimum number of one-second pauses Kenny needs to make when setting the microwave timer for $x$ minutes.</p>

