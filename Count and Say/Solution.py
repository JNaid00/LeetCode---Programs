# %%
class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        return self.recursive(1, n, 1)
    def recursive(self,start, n, ans):
        if (n == start):
            return ans
        strans = str(ans)
        output = ""
        i = 0
        while i < len(strans):
            count = 1
            temp = strans[i]
            while i + count < len(strans) and temp == strans[i + count]:
                count += 1

            i += count
            output += str(count) + str(temp)


        return self.recursive(start+1, n, int(output))



sol = Solution()
print(sol.countAndSay(1))
print(sol.countAndSay(2))
print(sol.countAndSay(3))
print(sol.countAndSay(4))
print(sol.countAndSay(5))
print(sol.countAndSay(6))
print(sol.countAndSay(7))


