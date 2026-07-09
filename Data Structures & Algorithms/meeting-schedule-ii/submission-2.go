/**
 * Definition of Interval:
 * type Interval struct {
 *    start int
 *    end   int
 * }
 */

func minMeetingRooms(intervals []Interval) int {
    n := len(intervals)
    start := make([]int,n)
    end := make([]int, n)
    for i,iv := range intervals{
        start[i] = iv.start
        end[i] = iv.end
    }
    sort.Ints(start)
    sort.Ints(end)
    rooms, maxRooms := 0,0
    i,j := 0,0
    for i < n {
        if start[i] < end[j]{
            rooms++
            i++
        } else {
            rooms--
            j++
        }
        maxRooms = max(maxRooms,rooms)
    }
    return maxRooms
}
