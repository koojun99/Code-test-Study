def solution(nums):
    nums.sort()
    ponkemons = []
    for i in range(len(nums)):
        if i > 0 and nums[i] == nums[i-1]:
            continue
        if len(ponkemons) == len(nums) / 2:
            break
        ponkemons.append(nums[i])
    answer = len(ponkemons)
    return answer