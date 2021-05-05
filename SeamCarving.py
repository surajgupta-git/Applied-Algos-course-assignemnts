class SeamCarving:
    # Helper Function to get the index of the min
    def min(self, list):
        m = list.index(min(list))
        return m

    def carve_seam(self, disruption: [[int]]) -> [int]:
        row = len(disruption)
        col = len(disruption)
        # 2D array to store values of each pixel
        D = [disruption[0]]

        for i in range(1, row):
            tmp = []
            for j in range(col):
                if j == 0:
                    tmp.append(disruption[i][j] + min(D[i - 1][j], D[i - 1][j + 1]))
                elif j == col - 1:
                    tmp.append(disruption[i][j] + min(D[i - 1][j], D[i - 1][j - 1]))
                else:
                    tmp.append(
                        disruption[i][j] + min(D[i - 1][j - 1], D[i - 1][j], D[i - 1][j + 1]))
            D.append(tmp)

        # backtrack to get the seam
        seam = [0] * col
        seam[row - 1] = self.min(D[row - 1])
        for i in range(row - 2, -1, -1):
            j = seam[i + 1]
            if j == 0:
                seam[i] = self.min(D[i][j:j + 2]) + j
            elif j == col - 1:
                seam[i] = self.min(D[i][j - 1:j + 1]) + j - 1
            else:
                seam[i] = self.min(D[i][j - 1:j + 2]) + j - 1

        return seam


