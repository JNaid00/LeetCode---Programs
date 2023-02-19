class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        length = len(intervals)
        for item in intervals:
            lower, upper = item[0], item[1]
            nextCounter = intervals.index(item) + 1
            for j in range(intervals.index(item) + 1, length):
                temp = intervals[nextCounter]
                nextLower, nextUpper = temp[0], temp[1]
                if nextLower <= upper:
                    item[1] = nextUpper if nextUpper > upper else upper
                    upper = item[1]
                    intervals.remove(temp)
                    length -= 1
                else:
                    nextCounter += 1
        return intervals

sol = Solution()
print(sol.merge([[1,3],[2,6],[8,10],[15,18]]))
print(sol.merge([[1,4],[4,5]]))
print(sol.merge([[1,3],[2,6],[8,10],[15,18], [18, 100]]))
print(sol.merge([[1,4],[2,3]]))
print(sol.merge([[1,2],[2,3],[3,4], [4,5],[5,6],[6,7],[7,8]]))