def solution(board, moves):
    
    basket = []
    count = 0
    for move in moves:
        for i in range(len(board)):
            if board[i][move-1] > 0:
                basket.append(board[i][move-1])
                board[i][move-1] = 0
                if len(basket) >= 2 and basket[-1] == basket[-2]:
                    basket.pop()  # 마지막 인형 제거
                    basket.pop()  # 마지막에서 두 번째 인형 제거
                    count += 2  # 터진 인형의 수를 카운트
                break
                
    return count