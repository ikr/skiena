def find(sorted_haystack, needle):
    return find_impl(sorted_haystack, needle, 0, len(sorted_haystack) - 1)

def find_impl(sorted_haystack, needle, lo, hi):
    if lo > hi:
        return -1
    mid = (lo + hi) // 2
    if sorted_haystack[mid] == needle:
        return mid
    if sorted_haystack[mid] < needle:
        return find_impl(sorted_haystack, needle, mid + 1, hi)
    return find_impl(sorted_haystack, needle, lo, mid - 1)
