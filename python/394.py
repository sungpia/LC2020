#https://leetcode.com/problems/decode-string/

class Solution:
    def decodeString(self, s: str) -> str:
        # O(N) one-pass solution exists?
        # 1. tokenize integers and those belongings
        state = "none"
        int_token = ""
        int_value = 0
        str_token = ""
        str_value = ""
        inner_token = ""
        inner_value = ""
        brac_count = 0
        res = ""
        for c in s:
            if state == "none":
                if c.isdigit():
                    int_token += c
                    state = "int"
                else:
                    str_token += c
                    state = "str"
            elif state == "int":
                if c.isdigit():
                    int_token += c
                else: # [
                    brac_count = 0
                    int_value = int(int_token)
                    int_token = ""
                    state = "inner"
            elif state == "inner":
                if c == '[':
                    brac_count += 1
                    inner_token += c
                elif c == ']':
                    brac_count -= 1
                    if brac_count == 0:

                        state = "none"
                        inner_value = inner_token
                        inner_token = ""
                        res += int_value * inner_value
                else:
                    inner_token += c
            elif state == "str":
                if c.isalpha():
                    str_token += c
                else:
                    str_value = str_token
                    str_token = ""
                    res += str_value
                    state = "none"
        res += str_token
        print(res)

s = Solution()
inp = "3[a2[c]]"
ans = s.decodeString(inp)
print(ans)








"""
Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

Automata
integer until [
closes until same number of ] met -> stringify 
this solution takes eager evaluation.

making these as tree 
then evaluates from the leaf
step1)
3[a2[c]]
  *
3   a2[c]
step2)
  *
3   +    (cause we met integer)
   a  * 
     2  c
     
2[abc]3[cd]3[a2[c]ef]
         +                 
   *             *                *
2    abc       3    cd        3       a2[c]ef
"""