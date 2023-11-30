def solution(price, money, count):
    price_list = [i for i in range(1, count+1)]
    payment = sum(price_list) * price - money
    if payment <= 0:
        return 0
    
    return payment