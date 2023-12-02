def solution(answers):
    students = {1: 0, 2: 0, 3: 0}
    sequence = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    for i in range(len(answers)):
        for j in range(3):
            if answers[i] == sequence[j][i % len(sequence[j])]:
                students[j+1] += 1
    max_score = max(students.values())
    sorted_students = [student for student, score in students.items() if score == max_score]

    return sorted_students