class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        freq = {}
        for n in nums:
            if freq.get(n) == None:
                freq[n] = 1
            else:
                return True
        return False