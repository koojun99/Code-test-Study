def solution(id_list, report, k):
    report_num = {user: 0 for user in id_list}
    email = [0 for _ in id_list]
    report = list(set(report))
    
    for rep in report:
        reportee = rep.split()[1]
        report_num[reportee] += 1
    for rep in report:
        reporter, reportee = rep.split()
        if report_num[reportee] >= k:
            email[id_list.index(reporter)] += 1
    return email