def solution(board, h, w):
    count = 0
    center = board[h][w]
    dh = [0,1,-1,0]
    dw = [1,0,0,-1]
    h_check = []
    w_check = []
    
    for i in range(4):
        nh = h + dh[i]
        nw = w + dw[i]
        if 0 <= nh < len(board) and 0 <= nw < len(board[0]):  # 범위 체크 수정
            if board[nh][nw] == center:
                count += 1
    
    return count