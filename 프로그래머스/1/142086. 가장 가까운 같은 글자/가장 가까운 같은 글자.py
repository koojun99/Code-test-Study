def solution(s):
    vocab = {}
    result = []
    for n in range(len(s)):
        if s[n] not in vocab:
            vocab[s[n]] = n
            result.append(-1)
        else:
            result.append(n - vocab[s[n]])
            vocab[s[n]] = n
    return result