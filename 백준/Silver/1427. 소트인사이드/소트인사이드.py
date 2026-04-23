n = list(input())

ans = []
for i in range(len(n)):
    ans.append(n[i])
    
ans.sort(reverse=True)

answer = ""

for n in ans:
    answer += str(n)

print(answer)