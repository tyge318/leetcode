class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        rec1 = abs(C-A)*abs(D-B)
        rec2 = abs(G-E)*abs(H-F)
        overlapping = max(min(C,G)-max(A,E),0)*max(min(D,H)-max(B,F),0)
        return rec1+rec2-overlapping
        