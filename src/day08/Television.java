package day08;

public class Television {
    // 멤버변수
    int channel;
    int volume;

    // 상기 멤버변수를 매개변수로 받아 초기화하는 생성자
    Television(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    // TV켜라
    void TVOn() {
        System.out.println("채널 : " + channel + " 볼륨 : " + volume);
    }

}
