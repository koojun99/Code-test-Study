def solution(phone_number):
    encoded = "*" *(len(phone_number) - 4) + phone_number[-4:]
    return encoded