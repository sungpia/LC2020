import collections

class my_dict(collections.OrderedDict):
    pass
class Solution:
    def frequencySort(self, s: str) -> str:
        d = dict()
        for c in s:
            if not c in d:
                d[c] = 1
            else:
                d[c] += 1

        print(sorted(d.items(), key=lambda kv: (kv[1], kv[0]), reverse=True))
        ret = ""

        for k, v in sorted(d.items(), key=lambda kv: (kv[1], kv[0]), reverse=True):
            ret += int(v) * k

        return ret
s = Solution()
inp = "Aabb"
ans = s.frequencySort(inp)
print(ans)

