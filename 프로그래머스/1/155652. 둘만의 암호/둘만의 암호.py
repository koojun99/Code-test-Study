import string
def solution(s, skip, index):
    alphabet_list = list(string.ascii_lowercase)
    result = []

    for char in s:
        if char in skip:
            result.append(char)
            continue

        current_index = alphabet_list.index(char)
        for _ in range(index):
            current_index = (current_index + 1) % len(alphabet_list)
            while alphabet_list[current_index] in skip:
                current_index = (current_index + 1) % len(alphabet_list)

        result.append(alphabet_list[current_index])
    return ''.join(result)