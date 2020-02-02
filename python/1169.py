from typing import List


class Solution:
    @staticmethod
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        ts = list(map(lambda taction: taction.split(','), transactions))
        its = set()
        record = dict()
        # Build map
        for t in ts:
            name = t[0]
            time = int(t[1])
            amount = int(t[2])
            location = t[3]

            if amount > 1000:
                its.add(','.join(t))

            record[(name, time)] = location

        for t in ts:
            name = t[0]
            time = int(t[1])
            location = t[3]

            for time_range in range(max(0, time-60), min(1001, time+61)):
                if (name, time_range) in record:
                    if record[(name, time_range)] != location:
                        its.add(','.join(t))

        return list(its)
