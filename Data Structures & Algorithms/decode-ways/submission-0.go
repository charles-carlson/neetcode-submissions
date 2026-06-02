func numDecodings(s string) int {
    return numDecodingsRec(s,0)
}
func numDecodingsRec(s string, i int) int {
    if i == len(s) {
        return 1
    }
    if s[i] == '0' {
        return 0
    }
    res := numDecodingsRec(s,i+1)
    if i < len(s) - 1 {
        if s[i] == '1' || (s[i] == '2' && s[i+1] < '7') {
            res += numDecodingsRec(s,i+2)
        }
    }
    return res
}