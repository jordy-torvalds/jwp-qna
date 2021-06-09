package qna.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

import static java.lang.String.format;

@Embeddable
public class Title {

    public static final int MAXIMUM_LENGTH = 100;

    @Column(length = MAXIMUM_LENGTH, nullable = false)
    private String title;

    protected Title() {

    }

    public Title(String title) {
        validate(title);

        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public void edit(String title) {
        validate(title);

        this.title = title;
    }

    private void validate(String title) {
        if (Objects.isNull(title)) {
            throw new IllegalArgumentException("제목은 null일 수 없습니다.");
        }
        if (title.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(format("제목의 최대 길이는 %d자 입니다.", MAXIMUM_LENGTH));
        }
    }

}
