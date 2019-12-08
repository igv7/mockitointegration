package mockitointegration.testspies;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class MockDemo {

	@Mock
	List<String> listMock = new ArrayList<>();

	@Test
	public void testMockReturnsZero() throws Exception {
		String str = "Mock";

		listMock.add(str);

		verify(listMock).add(str);
		assertEquals(0, listMock.size());
	}

}
