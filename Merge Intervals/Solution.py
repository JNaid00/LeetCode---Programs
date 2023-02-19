class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        # O(nlog(n))
        intervals.sort(key = lambda i : i[0])
        output = [intervals[0]]
        counter = 0
        for lower, upper in intervals[1:]:
            if lower <= output[-1][1]: 
                output[-1][1] = max(upper, output[-1][1])
            else:
                output.append([lower,upper])

        return output

sol = Solution()
print(sol.merge([[1,3],[2,6],[8,10],[15,18]]))
print(sol.merge([[1,4],[4,5]]))
print(sol.merge([[1,3],[2,6],[8,10],[15,18], [18, 100]]))
print(sol.merge([[1,4],[2,3]]))
print(sol.merge([[1,2],[2,3],[3,4], [4,5],[5,6],[6,7],[7,8]]))